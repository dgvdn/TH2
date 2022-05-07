package product.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import product.model.Music;

@Repository
public class JdbcMusicRepository implements MusicRepository {
	private JdbcTemplate jdbc;

	@Autowired
	public JdbcMusicRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public Iterable<Music> findAll() {
		return jdbc.query("select id, des, price from Product", this::mapRowToProduct);
	}

	@Override
	public Music findById(String id) {
		return jdbc.queryForObject("select id, des, price from Product where id=?", this::mapRowToProduct, id);
	}

	private Music mapRowToProduct(ResultSet rs, int rowNum) throws SQLException {
		return new Music(rs.getString("id"), rs.getString("des"), rs.getFloat("price"));
	}

	@Override
	public Music save(Music music) {
		jdbc.update("insert into Product (id, des, price) values (?, ?, ?)", music.getId(), music.getDes(),
				music.getPrice());
		return music;
	}
	@Override
	public Music edit(Music music, String id) {
		jdbc.update("update Product set id = ?, des = ?, price = ? where id = ?", music.getId(), music.getDes(),
				music.getPrice(), id);
		return music;
	}

	@Override
	public void delete(String id) {
		jdbc.update("DELETE FROM Product WHERE id = ?;", id);
		return;
	}
}

