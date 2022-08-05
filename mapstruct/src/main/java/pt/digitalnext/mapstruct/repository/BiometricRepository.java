package pt.digitalnext.mapstruct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.digitalnext.mapstruct.domain.model.BiometricData;

import java.util.List;

@Repository
public interface BiometricRepository extends JpaRepository<BiometricData, Long> {

    List<BiometricData> findByCc(String BiometricData);

    BiometricData findById(long id);
}
