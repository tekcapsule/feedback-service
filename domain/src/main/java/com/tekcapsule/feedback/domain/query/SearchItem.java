package com.tekcapsule.feedback.domain.query;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import in.devstream.core.domain.ValueObject;
import com.tekcapsule.feedback.domain.model.Name;
import com.tekcapsule.feedback.domain.model.Social;
import lombok.Builder;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class SearchItem implements ValueObject {
    private String photoUrl;
    private Name name;
    private String headLine;
    private Social social;
    private String activeSince;
    private int rating;
}
