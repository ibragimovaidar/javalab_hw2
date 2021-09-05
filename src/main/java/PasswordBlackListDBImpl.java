import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;

public class PasswordBlackListDBImpl implements PasswordBlackList {

	private final JdbcTemplate jdbcTemplate;

	//language=SQL
	private static final String SQL_SELECT_BY_PASSWORD =
			"SELECT id, password FROM password_black_list WHERE password = ?";

	private static final ResultSetExtractor<Boolean> containsResultSetExtractor = ResultSet::next;

	public PasswordBlackListDBImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean contains(String password) {
		Boolean result = jdbcTemplate.query(SQL_SELECT_BY_PASSWORD, containsResultSetExtractor, password);
		if (result == null){
			throw new RuntimeException();
		}
		return result;
	}
}
