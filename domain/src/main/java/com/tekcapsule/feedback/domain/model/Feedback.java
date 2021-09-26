package com.tekcapsule.feedback.domain.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.xml.internal.bind.v2.model.core.ID;
import com.tekcapsule.core.domain.AggregateRoot;
import com.tekcapsule.core.domain.BaseDomainEntity;
import lombok.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
@DynamoDBTable(tableName = "Mentor")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Feedback extends BaseDomainEntity<String> implements AggregateRoot {

    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBAutoGeneratedKey
    private ID id;
    @DynamoDBAttribute(attributeName="emailId")
    private String emailId;
    @DynamoDBAttribute(attributeName = "firstName")
    private String firstName;
    @DynamoDBAttribute(attributeName = "lastName")
    private String lastName;
    @DynamoDBAttribute(attributeName="subject")
    private String subject;
    @DynamoDBAttribute(attributeName="description")
    private String description;
    @DynamoDBAttribute(attributeName="read")
    private boolean read;

}