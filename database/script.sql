create table bank
(
    pin    varchar(10) null,
    date   varchar(50) null,
    type   varchar(20) null,
    amount varchar(20) null
);

create table login
(
    formno     varchar(20) null,
    cardnumber varchar(25) null,
    pin        varchar(10) null
);

create table signup
(
    formno         varchar(20) null,
    name           varchar(20) null,
    father_name    varchar(20) null,
    dob            varchar(20) null,
    gender         varchar(20) null,
    email          varchar(30) null,
    marital_status varchar(20) null,
    address        varchar(40) null,
    city           varchar(25) null,
    pincode        varchar(20) null,
    state          varchar(25) null
);

create table signupthree
(
    formno      varchar(20)  null,
    accountType varchar(40)  null,
    cardnumber  varchar(25)  null,
    pin         varchar(10)  null,
    facility    varchar(100) null
);

create table signuptwo
(
    formno          varchar(20) null,
    religion        varchar(20) null,
    category        varchar(20) null,
    income          varchar(20) null,
    education       varchar(20) null,
    occupation      varchar(20) null,
    pan             varchar(20) null,
    aadhar          varchar(20) null,
    seniorcitizen   varchar(20) null,
    existingaccount varchar(20) null
);


