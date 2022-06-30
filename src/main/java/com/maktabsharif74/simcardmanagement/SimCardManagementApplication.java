package com.maktabsharif74.simcardmanagement;

import com.maktabsharif74.simcardmanagement.domain.Customer;
import com.maktabsharif74.simcardmanagement.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class SimCardManagementApplication {

    public static void main(String[] args) {

        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();

        TypedQuery<Customer> typedQuery = entityManager.createQuery(
                "from Customer c", Customer.class
        );

        int size = 2;
        int page = 2;
        int offset = size * page;

        typedQuery.setMaxResults(size); /*size*/
        typedQuery.setFirstResult(offset); /*offset*/

        List<Customer> customerList = typedQuery.getResultList();

        customerList.forEach(data -> System.out.println(data.getId()));

    }
}
