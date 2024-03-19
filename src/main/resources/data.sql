INSERT INTO members (id, email, firstname) VALUES (1, 'somename', 'somename');
INSERT INTO members (id, email, firstname) VALUES (2, 'othername', 'othername');

INSERT INTO accounts (id, member_id, type) VALUES (1, 1, 'DINING_POINTS');
INSERT INTO accounts (id, member_id, type) VALUES (2, 2, 'DINING_POINTS');

INSERT INTO roles (id, name) VALUES (1, 'ROLE_STUDENT');

INSERT INTO members_roles (member_id, role_id) VALUES (1, 1);
INSERT INTO members_roles (member_id, role_id) VALUES (2, 1);

INSERT INTO events(id, name, start_date_time, end_date_time, account_type) VALUES(1, 'some-event', '2024-01-15 00:00:00', '2024-02-15 00:00:00', 'DINING_POINTS');

INSERT INTO events_members(event_id, member_id) VALUES(1, 1);
INSERT INTO events_members(event_id, member_id) VALUES(1, 2);

INSERT INTO sessions(id, name, event_id) VALUES(1, 'some-session', 1);
INSERT INTO sessions(id, name, event_id) VALUES(2, 'other-session', 1);

INSERT INTO records(id, member_id, session_id) VALUES(1, 1, 1);
INSERT INTO records(id, member_id, session_id) VALUES(2, 1, 2);
INSERT INTO records(id, member_id, session_id) VALUES(3, 2, 1);