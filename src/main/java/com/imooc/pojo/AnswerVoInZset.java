package com.imooc.pojo;

import org.springframework.data.redis.core.ZSetOperations.TypedTuple;

public class AnswerVoInZset implements TypedTuple<String> {

	String id;
    double score;
	public AnswerVoInZset(String id, double score) {
		this.id = id;
        this.score = score;
	}

	@Override
	public int compareTo(TypedTuple<String> o) {
		AnswerVoInZset o1 = (AnswerVoInZset) o;
        return new Double(this.score).compareTo(o1.getScore());
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public Double getScore() {
		// TODO Auto-generated method stub
		return score;
	}

	
}
