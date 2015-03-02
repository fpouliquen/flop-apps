
package org.flop.fsm.repository;

import java.math.BigInteger;

import org.flop.fsm.domain.Song;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SongRepository extends MongoRepository<Song, BigInteger>, CustomSongRepository {

}
