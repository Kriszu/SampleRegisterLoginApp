package com.kriszu.service;

import com.kriszu.model.Thread;
import com.kriszu.repository.ThreadRepository;
import com.kriszu.repository.UserRepository;
import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Kriszu on 24.10.2017.
 */
@Service
public class ThreadServiceImpl implements ThreadService {

    @Autowired
    private ThreadRepository threadRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public void save(Thread thread, String username) {

        thread.setTitle(thread.getTitle());
        thread.setContent(thread.getContent());
        thread.setUser(userRepository.findByUsername(username));
        threadRepository.save(thread);
    }

    @Override
    public Thread findByTitle(String title) {
        return  null;
    }

    @Override
    @PostConstruct
    public void getSampleThreadByParsing() {
        Thread thread = new Thread();
       try{
           Connection connection = Jsoup.connect("http://www.geekweek.pl/aktualnosci/32160/na-youtube-pojawily-sie-ukryte-reklamy-kopiace-kryptowaluty");
           Document document = connection.get();
           Elements article  = document.select("div.article-body");
           thread.setContent(article.first().toString());
           article = document.select("h1");
           thread.setTitle(article.first().toString());
           threadRepository.save(thread);
       } catch (IOException e){
           System.out.println("Error with parsing!!!!!");
       }
    }


}



