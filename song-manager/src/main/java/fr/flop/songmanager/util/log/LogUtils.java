package fr.flop.songmanager.util.log;

import fr.flop.songmanager.dao.entity.Song;
import fr.flop.songmanager.dao.entity.SongWriter;

/**
 * Log formatting.
 *
 */
public final class LogUtils {

	private LogUtils() {
	}

	public static String getLog(ELogFunction fonction, String message) {
		return String.format("[%s] - %s", fonction, message);
	}

	public static String getLog(Song song, ELogFunction fonction, String message) {
		return String.format("[%s] [%s] - %s", fonction, song.getTitle(), message);
	}

	public static String getLog(SongWriter songWriter, ELogFunction fonction, String message) {
		return String.format("[%s] [%s %s] - %s", fonction, songWriter.getFirstName(), songWriter.getLastName(),
				message);
	}
}
