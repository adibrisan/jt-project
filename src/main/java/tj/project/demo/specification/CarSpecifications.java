package tj.project.demo.specification;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import tj.project.demo.entity.Car;

import java.util.ArrayList;
import java.util.List;

public class CarSpecifications {

    public static Specification<Car> filterByBrandColorYear(String brand, String fuelType, Integer year) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.isNotBlank(brand)) {
                predicates.add(criteriaBuilder.equal(root.get("brand"), brand));
            }

            if (StringUtils.isNotBlank(fuelType)) {
                predicates.add(criteriaBuilder.equal(root.get("fuelType"), fuelType));
            }

            if (year != null && year > 1800) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("year"), year));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}

