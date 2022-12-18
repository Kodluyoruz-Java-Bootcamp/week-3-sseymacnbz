package emlakcepte.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import emlakcepte.model.Logging;
import emlakcepte.model.User;

@Repository
public class LoggingRepository {
	private static List<Logging> logList = new ArrayList<>();
	private String message = "";

	public void searchingLog(Logging log) { // Logları listeye ekleme
		logList.add(log);
	}

	public String printLogging(User user) { // Kayıtlı logları gelen kullanıcı bilgisine göre bastırma

		for (Logging log : logList) {

			if (log.getUser().equals(user)) {
				System.out.print(log.getProvince() + " ");
				System.out.println(log.getDistrict());

				message = log.getProvince() + " " + log.getDistrict();
			}
		}
		return message;
	}
}
