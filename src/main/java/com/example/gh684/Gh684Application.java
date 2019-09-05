package com.example.gh684;

import org.apache.kafka.streams.kstream.KStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;

@SpringBootApplication
@EnableBinding(Gh684Application.Bindings.class)
public class Gh684Application {

	public static void main(String[] args) {
		SpringApplication.run(Gh684Application.class, args);
	}


	@StreamListener("myinput")
	@SendTo("myoutput")
	public KStream<String, String> process( KStream<String, String> input) {
		return input;
	}


	public interface Bindings {

		String MYINPUT = "myinput";
		String MYOUTPUT = "myoutput";

		@Input(MYINPUT)
		KStream<String, String> input();

		@Output(MYOUTPUT)
		KStream<String, String> output();
	}

}
