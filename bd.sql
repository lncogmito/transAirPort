drop table product_info;
drop table category_info;
drop table order_line;
drop table product;
drop table category;
drop table `order`;
drop table `user`;
drop table address;
drop table locality;
drop table `language`;



create table `LANGUAGE`(
	CodeLanguage bigint not null auto_increment,
    `Name` varchar(30) not null,
    
    constraint PK_LANGUAGE primary key (CodeLanguage)
);

create table LOCALITY(
	LocalityId bigint not null auto_increment,
	`Name` varchar(30) not null,
	PostalCode int not null,
	Country varchar(30) not null,
	
	constraint PK_LOCALITY primary key(LocalityId)
);

create table ADDRESS(
	AddressId bigint not null auto_increment,
	Street varchar(50) not null,
	HouseNumber varchar(5) not null,
	BoxNumber varchar(5) default null,
	LocalityId bigint not null,
	
	constraint PK_ADDRESS primary key(AddressId),
	
	constraint FK_LOCALITY foreign key (localityId) references LOCALITY(localityId)
);

create table `USER` (
	Username varchar(30) not null,
	Email varchar(30) not null,
	Password varchar(60) not null,
	Authorities varchar(255) default null,
	NonExpired boolean not null,
	NonLocked boolean not null,
	CredentialNonExpired boolean not null,
	Enabled boolean not null,
	AddressId bigint not null,
	
	constraint PK_USER primary key(Username),
	
	constraint FK_ADDRESS foreign key (AddressId) references ADDRESS(AddressId)
);

create table `ORDER`(
	OrderId bigint not null auto_increment,
	Username varchar(30) not null,
	AddressId bigint not null,
	
	constraint PK_ORDER primary key(OrderId),
	
	constraint FK_USER foreign key(Username) references `USER`(Username),
	constraint FK_ADDRESS_ORDER foreign key(AddressId) references ADDRESS(AddressId)
);

create table CATEGORY(
	CodeCategory bigint not null auto_increment,
	CodeCategoryParent bigint default null,
	
	constraint PK_CATEGORY primary key(codeCategory),
	constraint FK_CATEGORY_PARENT foreign key (codeCategoryParent) references CATEGORY(CodeCategory)
);

create table PRODUCT(
	ProductId bigint not null auto_increment,
	Price double not null,
	VAT double not null,
	CodeCategory bigint not null,
	
	constraint PK_PRODUCT primary key(ProductId),
	
	constraint FK_CATEGORY foreign key (CodeCategory) references CATEGORY(CodeCategory)
);

create table ORDER_LINE(
	OrderLineId bigint not null auto_increment,
	LineNumber int not null,
	Price double not null,
	Quantity int not null,
	OrderId bigint not null,
	ProductId bigint not null,
	
	constraint PK_ORDER_LINE primary key(OrderLineId),
	
	constraint FK_ORDER foreign key (OrderId) references `ORDER`(OrderId),
	constraint FK_PROCUCT foreign key (ProductId) references PRODUCT(ProductId)
);

create table CATEGORY_INFO(
	CategoryInfoId bigint not null auto_increment,
    CodeCategory bigint not null,
    CodeLanguage bigint not null,
	`Name` varchar(50) not null,
	
	constraint PK_CATEGORY_INFO primary key(CategoryInfoId),
    constraint FK_CATEGORY_INFO foreign key (CodeCategory) references CATEGORY(CodeCategory),
    constraint FK_LANGUAGE_CATEGORY foreign key (CodeLanguage) references `LANGUAGE`(CodeLanguage)
);

create table PRODUCT_INFO(
	ProductInfoId bigint not null auto_increment,
	`Name` varchar(50) not null,
	Description varchar(255) not null,
    ProductId bigint not null,
    CodeLanguage bigint not null,
	
	constraint PK_PRODUCT_INFO primary key(ProductInfoId),
    constraint FK_PRODUCT_INFO foreign key (ProductId) references PRODUCT(ProductId),
    constraint FK_LANGUAGE_PRODUCT foreign key (CodeLanguage) references `LANGUAGE`(CodeLanguage)
);

INSERT INTO `transairport`.`locality`(`name`,`PostalCode`,`Country`)
VALUES("Namur",5000,"Belgique");

INSERT INTO `transairport`.`address`(`Street`,`HouseNumber`,`LocalityId`)
VALUES("Rue de la paix","32",1);


INSERT INTO `transairport`.`user`
(`Username`,`Email`,`Password`,`Authorities`,`NonExpired`,`NonLocked`,`CredentialNonExpired`,`Enabled`,`AddressId`)
VALUES
("admin","admin@admin.com", "$2a$10$eZ6DRFKR6/UBA3Nf1k3p4uGjrKYYtr9DpaMoFQAGfzW5dL5tBv3YO", "ROLE_ADMIN", true,true, true,true,1);