package com.Microservice.QuizService.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "quiz_questions")
public class QuestionEntity {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    private String category;

	    private String difficultylevel;

	    private String option1;
	    private String option2;
	    private String option3;
	    private String option4;

	    @Column(name = "question_title", columnDefinition = "TEXT")
	    private String questionTitle;

	    @Column(name = "right_answer", columnDefinition = "TEXT")
	    private String rightAnswer;

	    
	 // Getters and Setters
	    
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getDifficultylevel() {
			return difficultylevel;
		}

		public void setDifficultylevel(String difficultylevel) {
			this.difficultylevel = difficultylevel;
		}

		public String getOption1() {
			return option1;
		}

		public void setOption1(String option1) {
			this.option1 = option1;
		}

		public String getOption2() {
			return option2;
		}

		public void setOption2(String option2) {
			this.option2 = option2;
		}

		public String getOption3() {
			return option3;
		}

		public void setOption3(String option3) {
			this.option3 = option3;
		}

		public String getOption4() {
			return option4;
		}

		public void setOption4(String option4) {
			this.option4 = option4;
		}

		public String getQuestionTitle() {
			return questionTitle;
		}

		public void setQuestionTitle(String questionTitle) {
			this.questionTitle = questionTitle;
		}

		public String getRightAnswer() {
			return rightAnswer;
		}

		public void setRightAnswer(String rightAnswer) {
			this.rightAnswer = rightAnswer;
		}

	    

	    
}
