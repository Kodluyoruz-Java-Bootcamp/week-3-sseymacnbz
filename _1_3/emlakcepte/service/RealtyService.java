package emlakcepte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakcepte.client.Banner;
import emlakcepte.client.BannerServiceClient;
import emlakcepte.client.BannerServiceClnt;
import emlakcepte.model.Logging;
import emlakcepte.model.Realty;
import emlakcepte.model.User;
import emlakcepte.model.enums.RealtyType;
import emlakcepte.model.enums.UserType;
import emlakcepte.repository.LoggingRepository;
import emlakcepte.repository.RealtyRepository;

@Service
public class RealtyService {

	@Autowired
	private RealtyRepository realtyDao;
	
	@Autowired
	private LoggingService loggingService;
	
	// @Autowired // injection
	// private UserService userService;

	@Autowired
	private BannerServiceClient bannerServiceClient;

	public void create(Realty realty) {

		// userService.printAllUser();

		if (UserType.INDIVIDUAL.equals(realty.getUser().getType())) {
			// en fazla 5 ilan girebilir.

			System.out.println("Bireysel kullanıclar en fazla 5 ilan girebilir.");
		}

		realtyDao.saveRealty(realty);
		System.out.println("createRealty :: " + realty);

		// TODO :: banner-service çağır ve banner siparişi ver

		Banner bannerRequest = new Banner(String.valueOf(realty.getNo()), 1, "123123", "");

		Banner bannerResponse = bannerServiceClient.create(bannerRequest);

		if (bannerResponse.getAdet() > 1) {
			System.out.println("hata verilsin");
		}

	}

	public List<Realty> getAll() {
		return realtyDao.findAll();
	}

	public void printAll(List<Realty> realtList) {
		realtList.forEach(realty -> System.out.println(realty));
	}

	public void getAllByProvince(String province) {

		getAll().stream().filter(realty -> realty.getProvince().equals(province))
				// .count();
				.forEach(realty -> System.out.println(realty));

	}

	public List<Realty> getAllByUserName(User user) {
		return getAll().stream().filter(realty -> realty.getUser().getMail().equals(user.getMail())).toList();
	}

	public List<Realty> getActiveRealtyByUserName(User user) {

		return getAll().stream().filter(realty -> realty.getUser().getName().equals(user.getName()))
				.filter(realty -> RealtyType.ACTIVE.equals(realty.getStatus())).toList();

	}

	public void getByDistrict(User user, String province, String district) {
		
		loggingService.searchingLog(new Logging(user,province,district));
		
		for (Realty realty : getAll()) { // Tüm ilanlar alındı
			if (realty.getProvince().equalsIgnoreCase(province)) { // Şehirler eşleşiyorsa
				if (realty.getDistrict().equalsIgnoreCase(district)) { // İlçeler eşleşiyorsa
					System.out.println(realty.toString()); // ilanı stringe çevirip ver.
				}
			}
		}
		
	}
	
	public void getShowcase() {
		realtyDao.getShowcase();
	}
	
	public void getSizeOfRealtyByProvince(String province) {
		System.out.println(getAll().stream()
		.filter(realty -> realty.getProvince().equals(province)).count());
	}

}
