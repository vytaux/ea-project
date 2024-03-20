--  INSERT INTO members (id, firstname) VALUES (nextval('members_seq'), 'somename');
--  INSERT INTO members (id, firstname) VALUES (nextval('members_seq'), 'adonay');
--  INSERT INTO members (id, firstname) VALUES (nextval('members_seq'), 'Jean');
--  INSERT INTO members (id, firstname) VALUES (nextval('members_seq'), 'Claude');
--
--
--  INSERT INTO locations (id, name, location_type) VALUES (nextval('locations_seq'), 'Argiro', 'DINING_HALL');
--  INSERT INTO locations (id, name, location_type) VALUES (nextval('locations_seq'), 'Verill HALL', 'CLASSROOM');
--
--  INSERT INTO account_types (id, name, description, money_type, balance)
--  VALUES (nextval('account_types_seq'), 'CLASS', 'Lectures attendance', 'Points', 1000.0);
--
--  INSERT INTO account_types (id, name, description, money_type, balance)
--  VALUES (nextval('account_types_seq'), 'RESTAURANT', 'Food and Drinks', 'VirtualDollar', 4000.9);
--
-- INSERT INTO events (id)    VALUES (nextval('events_seq'));
--
-- -- INSERT INTO events_members(member_id,event_id)  VALUES (1,1);
-- -- INSERT INTO events_members(member_id,event_id)  VALUES (2,1);
--
-- INSERT INTO sessions (id, event_id) VALUES (nextval('sessions_seq'),1);
--  INSERT INTO sessions (id, event_id) VALUES (nextval('sessions_seq'),1);

-- INSERT INTO records (session_id,member_id)  VALUES (1,1);
--  INSERT INTO records (session_id,member_id)  VALUES (1,2);
--  INSERT INTO records (session_id,member_id)  VALUES (2,2);
SELECT * FROM members;

