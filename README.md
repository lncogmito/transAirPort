# transAirPort
## server mySQL
### DB Script
```SQL
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
	UserId bigint not null auto_increment,/** pas bon regarder les slides -> string et pas auto_increment **/
	Username varchar(30) not null,
	Email varchar(30) not null,
	Password varchar(60) not null,
	Authorities varchar(255) default null,
	NonExpired boolean not null,
	NonLocked boolean not null,
	CredentialNonExpired boolean not null,
	Enable boolean not null,
	AddressId bigint not null,
	
	constraint PK_USER primary key(UserId),
	
	constraint FK_ADDRESS foreign key (AddressId) references ADDRESS(AddressId)
);

create table `ORDER`(
	OrderId bigint not null auto_increment,
	UserId bigint not null,
	AddressId bigint not null,
	
	constraint PK_ORDER primary key(OrderId),
	
	constraint FK_USER foreign key(UserId) references `USER`(UserId),
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
```
