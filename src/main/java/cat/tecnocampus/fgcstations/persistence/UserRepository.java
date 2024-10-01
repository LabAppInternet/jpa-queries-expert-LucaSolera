package cat.tecnocampus.fgcstations.persistence;

import cat.tecnocampus.fgcstations.application.DTOs.*;
import cat.tecnocampus.fgcstations.domain.FavoriteJourney;
import cat.tecnocampus.fgcstations.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User>findByUsername(String username);

    @Query("SELECT UserDTOnoFJ (u.username, u.name, u.secondName, u.email) FROM User u WHERE u.name=:name")
    Optional<UserDTOnoFJ>findByUserDTOnoFJ(String username);

    @Query("SELECT UserDTOInterface (u.username, u.name, u.secondName, u.email) FROM User u WHERE u.name=:name")
    Optional<UserDTOInterface>findByUserDTOInterface(String username);

    @Query("SELECT UserDTOInterface (u.username, u.name, u.secondName, u.email) FROM User u WHERE u.name=:name AND u.secondName=:seccondName")
    List<UserDTOInterface>findUserDTOInterfaceByNameAndSecond(String name, String secondName);

    List<FavoriteJourney>findUserTopFavoriteJourney(String username);

    List<PopularDayOfWeek>findPopularDayOfWeekBy

    @Query("SELECT UserTopFavoriteJourney(u.username, u.name, u.secondName, u.email, u.numberOfFavoriteJourneys) FROM User u group by  ")
}
