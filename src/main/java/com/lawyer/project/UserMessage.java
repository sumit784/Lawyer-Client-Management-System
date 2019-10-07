// package com.lawyer.project;

// import javax.persistence.CascadeType;
// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;
// import javax.persistence.Table;

// @Entity
// @Table(name="user_messages")
// public class UserMessage
// {
//     @Id
//     @Column(name = "message_id")
//     @GeneratedValue
//     private int message_id;
    
//     @Column(name="text")
//     private String text;

    
//     @ManyToOne(cascade= CascadeType.ALL)
//     @JoinColumn(name = "user_id")
//     private UserCredentials user;

//     public UserMessage()
//     {
//         super();
//     }

//     public UserMessage(int message_id, String text, UserCredentials user)
//     {
//         super();
//         this.message_id = message_id;
//         this.text = text;
//         this.user = user;
//     }

//     public int getMessageId()
//     {
//         return message_id;
//     }

//     public void setMessageId(int message_id)
//     {
//         this.message_id = message_id;
//     }

//     public String getText()
//     {
//         return text;
//     }

//     public void setText(String text)
//     {
//         this.text = text;
//     }


//     public UserCredentials getUser()
//     {
//         return user;
//     }

//     public void setUser(UserCredentials user)
//     {
//         this.user = user;
//     }
// }