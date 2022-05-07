package product.repository;

import product.model.Music;

public interface MusicRepository {
	Iterable<Music> findAll();

	Music findById(String id);

	Music save(Music music);
	
	Music edit(Music music, String id);
	
	void delete(String id);
}
