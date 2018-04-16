package com.saurabh.genericexcelconverter.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saurabh.genericexcelconverter.api.model.Note;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.net.UnknownHostException;

/**
 * This class will have functionality required when running integration tests so
 * that invidivual classes do not need to implement the same functionality.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public abstract class BaseIntegrationTest {

	private static MongodExecutable mongodExecutable;
	@Autowired
	protected MockMvc mockMvc;
	protected ObjectMapper mapper;
	@Autowired
	protected MongoTemplate mongoTemplate;

	/**
	 * Here we are setting up an embedded mongodb instance to run with our
	 * integration tests.
	 *
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	@BeforeAll
	public static void beforeClass() throws UnknownHostException, IOException {

		MongodStarter starter = MongodStarter.getDefaultInstance();

		IMongodConfig mongoConfig = new MongodConfigBuilder()
				.version(Version.Main.PRODUCTION)
				.net(new Net(27017, false))
				.build();

		mongodExecutable = starter.prepare(mongoConfig);

		try {
			mongodExecutable.start();
		} catch (Exception e) {
			closeMongoExecutable();
		}
	}

	@AfterAll
	public static void afterClass() {
		closeMongoExecutable();
	}

	private static void closeMongoExecutable() {
		if (mongodExecutable != null) {
			mongodExecutable.stop();
		}
	}

	@BeforeEach
	public void setUp() {
		mapper = new ObjectMapper();
	}

	@AfterEach
	public void after() {
		mongoTemplate.dropCollection(Note.class);
	}

}
