CREATE KEYSPACE IF NOT EXISTS investapp WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : '1' };

-- Create Stocks Table
CREATE TABLE IF NOT EXISTS investapp.stocks (
	account_id int,
	owned int, 
	symbol text, 
	name text, 
	price double,  
	changes_percentage double, 
	change double, 
	day_low double, 
	day_high double, 
	year_high double, 
	year_low double,  
	market_cap double, 
	price_avg50 double, 
	price_avg200 double, 
	volume double, 
	avg_volume double, 
	exchange text, 
	open double, 
	previousClose double, 
	eps double, 
	pe double, 
	earnings_announcement text, 
	shares_outstanding double, 
	timestamp double,
	PRIMARY KEY (account_id,symbol)
);



-- Create Accounts Table
CREATE TABLE IF NOT EXISTS
investapp.accounts (
id int PRIMARY KEY,
first_name text,
last_name text,
funds double,
credit double
);

-- Create Credit Cards Table
CREATE TABLE IF NOT EXISTS investapp.creditcards (
	account_id int,
    card_num text,
	first_name text,
	last_name text,
    type text,
    ccv text,
    exp_date text,
    PRIMARY KEY (card_num)
);

-- Create Loans Table
CREATE TABLE IF NOT EXISTS investapp.loans (
	account_id int PRIMARY KEY,
	timestamp Timestamp,
	loan_amount double,
	purpose text,
	gross_earning double,
	total_expenses double,
	loan_term int,
	loan_status text,
	approved boolean
);
	
	