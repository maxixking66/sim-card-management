package com.maktabsharif74.simcardmanagement.repository.impl;

import com.maktabsharif74.simcardmanagement.base.repository.impl.BaseRepositoryImpl;
import com.maktabsharif74.simcardmanagement.domain.Customer;
import com.maktabsharif74.simcardmanagement.domain.FamiliarityMethod;
import com.maktabsharif74.simcardmanagement.repository.CustomerRepository;
import com.maktabsharif74.simcardmanagement.service.dto.CustomerSearch;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer, Long>
        implements CustomerRepository {

    public CustomerRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Customer> getEntityClass() {
        return Customer.class;
    }

    @Override
    public boolean existsByCode(String code) {
        return entityManager.createQuery(
                "select (count(c.id) > 0) from Customer c where c.code = :code",
                Boolean.class
        ).setParameter("code", code).getSingleResult();

    }

    @Override
    public List<Customer> findAllByCreateDateLessThanEqual(ZonedDateTime createDate) {
        return entityManager.createQuery(
                "select c from Customer c where c.createDate <= :createDate",
                Customer.class
        ).setParameter("createDate", createDate).getResultList();
    }

    @Override
    public List<Customer> findAllByCreateDateLessThan(ZonedDateTime createDate) {
        return entityManager.createQuery(
                "select c from Customer c where c.createDate < :createDate",
                Customer.class
        ).setParameter("createDate", createDate).getResultList();
    }

    @Override
    public List<Customer> findAllByCreateDateGreaterThanEqual(ZonedDateTime createDate) {
        return entityManager.createQuery(
                "select c from Customer c where c.createDate >= :createDate",
                Customer.class
        ).setParameter("createDate", createDate).getResultList();
    }

    @Override
    public List<Customer> findAllByCreateDateGreaterThan(ZonedDateTime createDate) {
        return entityManager.createQuery(
                "select c from Customer c where c.createDate > :createDate",
                Customer.class
        ).setParameter("createDate", createDate).getResultList();
    }

    @Override
    public List<Customer> findAllByCreateDateIsBetween(ZonedDateTime fromDate, ZonedDateTime toDate) {
        return entityManager.createQuery(
                        "select c from Customer c where c.createDate between :fromDate and :toDate",
                        Customer.class
                ).setParameter("fromDate", fromDate)
                .setParameter("toDate", toDate)
                .getResultList();
    }

    public FamiliarityMethod getMethodByCustomerId(Long customerId) {
        return entityManager.createQuery(
                "select c from Customer c where c.id = :id",
                FamiliarityMethod.class
        ).setParameter("id", customerId).getSingleResult();
    }

    @Override
    public List<Customer> findAll(CustomerSearch customerSearch) {
        String query = "select c from Customer c ";
        boolean isFirstWhereClause = true;

        if (customerSearch.getFirstName() != null && !customerSearch.getFirstName().isEmpty()) {
            isFirstWhereClause = false;
            query = query.concat("where c.firstName like :firstName ");
        }

        if (customerSearch.getLastName() != null && !customerSearch.getLastName().isEmpty()) {
            if (isFirstWhereClause) {
                isFirstWhereClause = false;
                query = query.concat("where c.lastName like :lastName ");
            } else {
                query = query.concat("and c.lastName like :lastName ");
            }
        }

        if (customerSearch.getUsername() != null && !customerSearch.getUsername().isEmpty()) {
            if (isFirstWhereClause) {
                isFirstWhereClause = false;
                query = query.concat("where c.username like :username ");
            } else {
                query = query.concat("and c.username like :username ");
            }
        }

        if (customerSearch.getCode() != null && !customerSearch.getCode().isEmpty()) {
            if (isFirstWhereClause) {
                isFirstWhereClause = false;
                query = query.concat("where c.code like :code ");
            } else {
                query = query.concat("and c.code like :code ");
            }
        }

        if (customerSearch.getFamiliarityMethodId() != null) {
            if (isFirstWhereClause) {
                isFirstWhereClause = false;
                query = query.concat("where c.familiarityMethod.id = :familiarityMethodId ");
            } else {
                query = query.concat("and c.familiarityMethod.id = :familiarityMethodId ");
            }
        }

        TypedQuery<Customer> typedQuery = entityManager.createQuery(query, Customer.class);

        if (customerSearch.getFirstName() != null && !customerSearch.getFirstName().isEmpty()) {
            typedQuery.setParameter("firstName", "%".concat(customerSearch.getFirstName()).concat("%"));
        }

        if (customerSearch.getLastName() != null && !customerSearch.getLastName().isEmpty()) {
            typedQuery.setParameter("lastName", "%".concat(customerSearch.getLastName()).concat("%"));
        }

        if (customerSearch.getUsername() != null && !customerSearch.getUsername().isEmpty()) {
            typedQuery.setParameter("username", "%".concat(customerSearch.getUsername()).concat("%"));
        }

        if (customerSearch.getCode() != null && !customerSearch.getCode().isEmpty()) {
            typedQuery.setParameter("code", "%".concat(customerSearch.getCode()).concat("%"));
        }

        if (customerSearch.getFamiliarityMethodId() != null) {
            typedQuery.setParameter("familiarityMethodId", customerSearch.getFamiliarityMethodId());
        }

        return typedQuery.getResultList();
    }

    @Override
    public List<Customer> findAllWithCriteria(CustomerSearch customerSearch) {
//        select c from Customer c where c.firstName

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
//      from Customer c
//        root = c                          from Customer
        Root<Customer> root = criteriaQuery.from(Customer.class);
//        criteriaQuery.select(root);


////        where   field  operator  value
////        root.get("firstName") = c.firstName
//        criteriaQuery.where(
////                              operator
//                criteriaBuilder.equal(
////                        field                 value
//                        root.get("firstName"), "mohsen"
//                )
//        );

        List<Predicate> predicates = new ArrayList<>();
        addFirstNamePredicate(predicates, root, criteriaBuilder, customerSearch.getFirstName());
        addLastNamePredicate(predicates, root, criteriaBuilder, customerSearch.getLastName());
        addIsActivePredicate(predicates, root, criteriaBuilder, customerSearch.getActive());
        addUsernamePredicate(predicates, root, criteriaBuilder, customerSearch.getUsername());
        addCodePredicate(predicates, root, criteriaBuilder, customerSearch.getCode());
        addFamiliarityMethodPredicate(predicates, root, criteriaBuilder,
                customerSearch.getFamiliarityMethodId());

        criteriaQuery.where(
                criteriaBuilder.and(
                        predicates.toArray(
                                new Predicate[0]
                        )
                )
        );

        criteriaQuery.orderBy(
//                order by field direction   -> order by c.createDate desc

//                              direction
                criteriaBuilder.desc(
                        root.get("createDate")
                )
        );

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    private void addFamiliarityMethodPredicate(List<Predicate> predicates, Root<Customer> root,
                                               CriteriaBuilder criteriaBuilder, Long familiarityMethodId) {
        if (familiarityMethodId != null) {
            predicates.add(
                    criteriaBuilder.equal(
//                            c.familiarityMethod.id
//                            c.familiarityMethod -> root.get("familiarityMethod")
//                            c.familiarityMethod.id -> root.get("familiarityMethod").get("id")
                            root.get("familiarityMethod").get("id"), familiarityMethodId
                    )
            );
        }
    }

    private void addCodePredicate(List<Predicate> predicates, Root<Customer> root,
                                  CriteriaBuilder criteriaBuilder, String code) {
        if (code != null && !code.isEmpty()) {
            predicates.add(
                    criteriaBuilder.like(
                            root.get("code"), "%" + code + "%"
                    )
            );
        }
    }

    private void addUsernamePredicate(List<Predicate> predicates, Root<Customer> root,
                                      CriteriaBuilder criteriaBuilder, String username) {
        if (username != null && !username.isEmpty()) {
            predicates.add(
                    criteriaBuilder.like(
                            root.get("username"), "%" + username + "%"
                    )
            );
        }
    }

    private void addIsActivePredicate(List<Predicate> predicates, Root<Customer> root,
                                      CriteriaBuilder criteriaBuilder, Boolean active) {
        if (active != null) {
            if (active) {
                predicates.add(
                        criteriaBuilder.isTrue(
                                root.get("isActive")
                        )
                );
            } else {
                predicates.add(
                        criteriaBuilder.or(
                                criteriaBuilder.isFalse(root.get("isActive")),
                                criteriaBuilder.isNull(root.get("isActive"))
                        )
                );
            }
        }
    }

    private void addLastNamePredicate(List<Predicate> predicates, Root<Customer> root,
                                      CriteriaBuilder criteriaBuilder, String lastName) {
        if (lastName != null && !lastName.isEmpty()) {
            predicates.add(
                    criteriaBuilder.like(
                            root.get("lastName"), "%" + lastName + "%"
                    )
            );
        }
    }

    private void addFirstNamePredicate(List<Predicate> predicates, Root<Customer> root,
                                       CriteriaBuilder criteriaBuilder, String firstName) {
        if (firstName != null && !firstName.isEmpty()) {

            ////        where   field  operator  value and field2  operator2  value2
            Path<String> field = root.get("firstName");
            Predicate predicate = criteriaBuilder.like(
                    field, "%" + firstName + "%"
            );
            predicates.add(predicate);

            /*predicates.add(
                    criteriaBuilder.like(
                            root.get("firstName"),
                            "%" + firstName + "%"
                    )
            );*/

        }
    }
}
