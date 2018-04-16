package com.saurabh.genericexcelconverter.api.dao;

import com.saurabh.genericexcelconverter.api.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {

	/**
	 * This method will retrieve the justice league member details pertaining to
	 * the name passed in.
	 *
	 * @param date the name of the justice league member to search and retrieve.
	 * @return an instance of {@link Note} with the member
	 * details.
	 */
	//@Query("{ 'date' : {$regex: ?0, $options: 'i' }}")
	Note findByDate(final String date);
}
