/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackages;


import java.util.*;

public class Comment {
    
    private String id;
    private String heading;
    private String content;
    private Date timestamp;
    private String userId;

    public String getId() {
        return id;
    }

    public String getHeading() {
        return heading;
    }

    public String getContent() {
        return content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    
}