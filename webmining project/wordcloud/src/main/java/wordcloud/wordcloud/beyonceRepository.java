package wordcloud.wordcloud;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface beyonceRepository extends MongoRepository<beyonce, String> {
	
}//จะใช้spring boot framwork เอาไว้เเมพกับMongoDB โดยต้องมีmodelมารองรับ