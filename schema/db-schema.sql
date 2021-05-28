create table schedule_calculation_event(
    schedule_calculation_event_id int not null primary key auto_increment,
    schedule_calculation_event_date date not null,
    capital double not null,
    installment_type varchar(50) not null,
    installment_amount int not null,
    interest_rate double not null,
    withdrawal_date date not null,
    commission_rate double not null,
    insurance boolean not null,
    age int null,
    sum_up_capital_installment double not null,
    loan_paid_out_amount double not null,
    commission_amount double not null,
    insurance_total_cost double not null,
    loan_total_cost double not null,
    aprc double not null
);
create table payments(
    payment_index int not null,
    payment_date date not null,
    capital_payment double not null,
    interest_payment double not null,
    remaining_debt double not null,
    insurance_premium_value double null,
    schedule_calculation_event_id int not null,
    key (schedule_calculation_event_id),
    constraint payment_to_order foreign key (schedule_calculation_event_id) references schedule_calculation_event(schedule_calculation_event_id)
);
