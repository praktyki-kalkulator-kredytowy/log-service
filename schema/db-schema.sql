create table orders(
    orders_id int not null primary key auto_increment,
    orders_date date not null
);
create table schedule_configurations(
    orders_id int not null,
    capital double not null,
    installment_type Enum('CONSTANT','DECREASING') not null,
    installment_amount int not null,
    interest_rate double not null,
    withdrawal_date date not null,
    commission_rate double not null,
    insurance boolean not null,
    age int not null,
    key (orders_id),
    constraint configuration_to_order foreign key (orders_id) references orders(orders_id)
);
create table installments(
    orders_id int not null,
    installment_index int not null,
    installment_date date not null,
    capital_installment double not null,
    interest_installment double not null,
    remaining_debt double not null,
    key (orders_id),
    constraint installment_to_order foreign key (orders_id) references orders(orders_id)
);
create table insurance_premiums(
    orders_id int not null,
    insurance_premium_index int not null,
    insurance_premium_date date not null,
    insurance_premium_value double not null,
    key (orders_id),
    constraint insurance_to_order foreign key (orders_id) references orders(orders_id)
);
create table schedule_summary(
    orders_id int not null,
    sum_up_capital_installment double not null,
    loan_paid_out_amount double not null,
    commission_amount double not null,
    insurance_total_cost double not null,
    loan_total_cost double not null,
    aprc double not null,
    key (orders_id),
    constraint summary_to_order foreign key (orders_id) references orders(orders_id)
);

