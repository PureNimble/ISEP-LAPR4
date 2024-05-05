<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764"/>

# US 1001 - Register a customer and the system automatically creates a user for that customer

# 4. Tests 

**Some tests of the Customer class**
```java
    @Test
    public void ensureCustomerEqualsPassesForTheSameCustomerCode() throws Exception {

        final Customer aCustomer = getNewDummyCustomer(aCustomerCode);
        final Customer anotherCustomer = getNewDummyCustomer(aCustomerCode);
        final boolean expected = aCustomer.equals(anotherCustomer);

        assertTrue(expected);
    }

    @Test
    public void ensureCustomerEqualsFailsForDifferenteCustomerCode() throws Exception {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.ADMIN);

        final Customer aCustomer = getNewDummyCustomer(aCustomerCode);
        final Customer anotherCustomer = getNewDummyCustomer(anotherCustomerCode);
        final boolean expected = aCustomer.equals(anotherCustomer);

        assertFalse(expected);
    }

    @Test
    public void ensureCustomerEqualsAreTheSameForTheSameInstance() throws Exception {
        final Customer aCustomer = getNewDummyCustomer(aCustomerCode);
        final boolean expected = aCustomer.equals(aCustomer);

        assertTrue(expected);
    }

    @Test
    public void ensureCustomerEqualsFailsForDifferenteObjectTypes() throws Exception {
        final Customer aCustomer = getNewDummyCustomer(aCustomerCode);
        final boolean expected = aCustomer.equals(getNewDummyCustomer(anotherCustomerCode));

        assertFalse(expected);
    }

    @Test
    public void ensureCustomerIsTheSameAsItsInstance() throws Exception {
        final Customer aCustomer = getNewDummyCustomer(aCustomerCode);
        final boolean expected = aCustomer.sameAs(aCustomer);

        assertTrue(expected);
    }

    @Test
    public void ensureTwoCustomerWithDifferentCustomerCodesAreNotTheSame() throws Exception {
        final Customer aCustomer = dummyCustomer(aCustomerCode);
        final Customer anotherCustomer = dummyCustomer(anotherCustomerCode);
        final boolean expected = aCustomer.sameAs(anotherCustomer);

        assertFalse(expected);
    }
```

# 5. Construction (Implementation)

**RegisterCustomerController**
```java
    public Customer registerCustomer(final String name, final String address, final String customerCode,
            final String email, final String phoneNumber) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        final UserSession s = authz.session().orElseThrow(IllegalStateException::new);
        final SystemUser manager = s.authenticatedUser();
        return createCustomer(name, address, customerCode, email, phoneNumber, manager);
    }

    public CustomerUser registerCustomerUser(final Customer customer,
            final SystemUser systemUser) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        return createCustomerUser(customer, systemUser);
    }

    private Customer createCustomer(final String name, final String address, final String customerCode,
            final String email, final String phoneNumber, final SystemUser manager) {
        final Customer customer = doCreateCustomer(name, address, customerCode, email, phoneNumber, manager);
        return customerRepository.save(customer);
    }

    private CustomerUser createCustomerUser(final Customer customer,
            final SystemUser systemUser) {
        final CustomerUser customerUser = doCreateCustomerUser(customer, systemUser);
        return customerUserRepository.save(customerUser);
    }

    private Customer doCreateCustomer(final String name, final String address, final String customerCode,
            final String email, final String phoneNumber, final SystemUser manager) {
        return new CustomerBuilder().with(name, address, customerCode, email, phoneNumber, manager).build();
    }

    private CustomerUser doCreateCustomerUser(final Customer customer,
            final SystemUser systemUser) {
        return new CustomerUserBuilder().with(customer,
                systemUser).build();
    }
```

# 6. Integration and Demo 

In the following images, we can see a demonstration of the registration of a customer.

<p align="center">Customer Registration</p>

![RegisterCustomer](resources/registercustomer.png)

The user must provide all the information shown above to register a customer.

# 7. Observations

The implementation of the customer registration was a success

<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764&section=footer"/>