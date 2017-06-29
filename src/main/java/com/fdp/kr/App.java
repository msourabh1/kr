package com.fdp.kr;

import java.util.ArrayList;
import java.util.List;

import com.fdp.kr.datamodel.Tag;
import com.fdp.kr.datamodel.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Tag tag1  = new Tag();
        tag1.setTagId("t1"); // There can be multiple ways of generating tag id
        tag1.setTagString("javascript");
        
        Tag tag2 = new Tag();
        tag2.setTagId("t2");
        tag2.setTagString("java");
        
        User user  = new User();
        user.setUserId("u1");
        user.setFirstname("Swami");
        user.setLastname("Vivekananda");
        
        List<Tag> subscribedTags = new ArrayList<Tag>();
        subscribedTags.add(tag1);
        subscribedTags.add(tag2);
        
        user.setTags(subscribedTags);
        
        System.out.println(user.getLastname());
    }
}
