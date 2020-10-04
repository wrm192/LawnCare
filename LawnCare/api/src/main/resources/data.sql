-- Each City should be added here that is part of the "area"
Insert  INTO country (id, name, country_code) VALUES (1, 'Canada', 'CA');

INSERT INTO city (id, name, city_code, country_id) VALUES (1, 'ottawa', 'OTT', 1);

INSERT INTO membership (id, name) VALUES (1, 'Residential');
INSERT INTO membership (id, name) VALUES (2, 'Commercial');