package com.praktyki.log.app.data.utils;

import com.praktyki.log.app.data.entities.ScheduleCalculationEventEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import javax.persistence.metamodel.SingularAttribute;
import java.util.function.Function;

public class SpecUtils {

    public static Specification<ScheduleCalculationEventEntity> ignoreNull(Object o, Spec spec) {
        return (root, query, criteriaBuilder) -> {
            if (o == null) return criteriaBuilder.conjunction();
            return spec.createPredicate(root, criteriaBuilder);

        };
    }

    public static <T extends Comparable<? super T>> Specification<ScheduleCalculationEventEntity> gte(
            T obj,
            Function<Root<ScheduleCalculationEventEntity>, Path<T>> pathSupplier) {
        return ignoreNull(obj, (root, builder) -> builder.greaterThanOrEqualTo(pathSupplier.apply(root), obj));
    }

    public static <T extends Comparable<? super T>> Specification<ScheduleCalculationEventEntity> lte(
            T obj,
            Function<Root<ScheduleCalculationEventEntity>, Path<T>> pathSupplier) {
        return ignoreNull(obj, (root, builder) -> builder.lessThanOrEqualTo(pathSupplier.apply(root), obj));
    }

    @FunctionalInterface
    public interface Spec {
        Predicate createPredicate(Root<ScheduleCalculationEventEntity> root, CriteriaBuilder builder);
    }
}
