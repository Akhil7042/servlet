package com.sapient.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;


/**
 * @Author: Akhil
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Question {
    
	@BsonId
	private ObjectId id;
	private String uId;
    private String content;
    private String status;
    /*
    List<ObjectId> comments;
    List<ObjectId> tags;
*/

}
