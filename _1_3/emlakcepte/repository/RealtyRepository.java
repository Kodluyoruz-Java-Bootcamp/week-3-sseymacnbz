package emlakcepte.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import emlakcepte.model.Realty;

@Repository
public class RealtyRepository {

	private static List<Realty> realtyList = new ArrayList<>();

	public void saveRealty(Realty realty) {
		realtyList.add(realty);
	}

	public List<Realty> findAll() {
		return realtyList;
	}
	
	public void getShowcase() {
		Collections.shuffle(realtyList); // Random olması için ilanlar karıştırıldı
		int randomShowcases = 10; // 10 adet ilan seçeceğimiz belirtildi
		System.out.println(realtyList.subList(0, randomShowcases).toString()); // İlanlardan bir subList oluşturulup bastırıldı
	}

}
