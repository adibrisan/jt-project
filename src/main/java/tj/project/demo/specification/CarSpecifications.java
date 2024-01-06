package tj.project.demo.specification;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import tj.project.demo.entity.Car;

import java.util.ArrayList;
import java.util.List;

public class CarSpecifications {

    public static Specification<Car> filterByBrandColorYear(String brand, String color, Integer year) {
        return (root, query, criteriaBuilder) -> {
            // Lista pentru a stoca condițiile de filtrare
            List<Predicate> predicates = new ArrayList<>();

            // Adaugăm condiții în funcție de valoarea primită pentru fiecare câmp
            if (StringUtils.isNotBlank(brand)) {
                predicates.add(criteriaBuilder.equal(root.get("brand"), brand));
            }

            if (StringUtils.isNotBlank(color)) {
                predicates.add(criteriaBuilder.equal(root.get("color"), color));
            }

            if (year != null && year > 0) {
                predicates.add(criteriaBuilder.equal(root.get("year"), year));
            }

            // Construim condiția finală cu AND logic între predicate
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}

