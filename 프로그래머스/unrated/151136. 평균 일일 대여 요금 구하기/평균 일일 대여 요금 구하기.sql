select round(ex.df, 0) as average_fee
from (select avg(daily_fee) as df
      from car_rental_company_car as car
      where car.car_type = 'SUV') ex;