package cat.tecnocampus.fgcstations.persistence;

import cat.tecnocampus.fgcstations.application.DTOs.JourneyDTO;
import cat.tecnocampus.fgcstations.domain.Journey;
import cat.tecnocampus.fgcstations.domain.JourneyId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JourneyRepository extends JpaRepository<Journey, JourneyId> {

    @Query("SELECT JourneyDTO(j.origin, j.destination) FROM Journey j")
    List<JourneyDTO> findAllJourneysDTO();

    Optional<Journey> findByOriginNameAndDestinationName(String origin, String destination);

    Optional<JourneyId> findJourneyIdByOriginNameAndDestinationName(String origin, String destination);

}
