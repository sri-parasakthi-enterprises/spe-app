package com.spe.spedashboardservice.model;

//import java.util.ArrayList;
import java.util.List;

//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class PageHelper<T>
//	extends PageImpl<T>
{

    /**
	 * 
	 */
//	private static final long serialVersionUID = -1634323296074684000L;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    // Note: I don't need a sort, so I'm not including one here.
    // It shouldn't be too hard to add it in though.
    public PageHelper(@JsonProperty("content") List<T> content,
            @JsonProperty("number") int number,
            @JsonProperty("size") int size,
            @JsonProperty("totalElements") Long totalElements,
            @JsonProperty("pageable") JsonNode pageable,
            @JsonProperty("last") boolean last,
            @JsonProperty("totalPages") int totalPages,
            @JsonProperty("sort") JsonNode sort,
            @JsonProperty("first") boolean first,
            @JsonProperty("numberOfElements") int numberOfElements) {

//		super(content, PageRequest.of(number, size), totalElements);
	}

    public PageHelper(List<T> content, Pageable pageable, long total) {
//        super(content, pageable, total);
    }
 
    public PageHelper(List<T> content) {
//        super(content);
    }
 
    public PageHelper() {
//        super(new ArrayList<>());
    }
}