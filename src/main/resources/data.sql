INSERT INTO members (id, firstname) VALUES (91, 'somename');
SELECT setval(pg_get_serial_sequence('members', 'id'), coalesce(max(id),0) + 1, false) FROM members;


INSERT INTO locations (id, name, location_type) VALUES (91, 'Argiro', 'DINING_HALL');
SELECT setval(pg_get_serial_sequence('locations', 'id'), coalesce(max(id),0) + 1, false) FROM locations;


INSERT INTO account_types (id, name, description, money_type, balance)
    VALUES (91, 'CLASS', 'Lectures attendance', 'Points', 1000.0);
SELECT setval(pg_get_serial_sequence('account_types', 'id'), coalesce(max(id),0) + 1, false) FROM account_types;


-- User 1 has 2 accounts (CLASS and RESTAURANT)
INSERT INTO accounts (id, member_id, account_type_id, balance) VALUES (91, 91, 91, 1000.0);
SELECT setval(pg_get_serial_sequence('accounts', 'id'), coalesce(max(id),0) + 1, false) FROM accounts;


-- Event 1 is a CLASS event, User 1 has registered for it
INSERT INTO events (id, location_id, account_type_id, start_date_time, end_date_time)
    VALUES (91, 91, 91, '2024-01-01 10:00:00', '2024-02-01 12:00:00');
SELECT setval(pg_get_serial_sequence('events', 'id'), coalesce(max(id),0) + 1, false) FROM events;


-- User 1 has registered for event 1
INSERT INTO events_members(member_id,event_id)  VALUES (91,91);


-- Event 1 has 2 sessions
INSERT INTO sessions (id, event_id, start_date_time, end_date_time) VALUES (91,91, '2024-01-02 10:00:00', '2024-01-02 12:00:00');
INSERT INTO sessions (id, event_id, start_date_time, end_date_time) VALUES (92,91, '2024-01-03 10:00:00', '2024-01-03 12:00:00');
SELECT setval(pg_get_serial_sequence('sessions', 'id'), coalesce(max(id),0) + 1, false) FROM sessions;


INSERT INTO records (session_id,member_id, scan_date_time)  VALUES (91,91, '2024-01-02 11:00:08');
SELECT setval(pg_get_serial_sequence('records', 'id'), coalesce(max(id),0) + 1, false) FROM records;


INSERT INTO scanners (id, location_id) VALUES (91, 91);
SELECT setval(pg_get_serial_sequence('scanners', 'id'), coalesce(max(id),0) + 1, false) FROM scanners;