INSERT INTO members (id, email, firstname) VALUES (91, 'somename', 'somename');
INSERT INTO members (id, email, firstname) VALUES (92, 'othername', 'othername');

INSERT INTO accounts (id, member_id, type) VALUES (91, 91, 'DINING_POINTS');
INSERT INTO accounts (id, member_id, type) VALUES (92, 92, 'DINING_POINTS');

INSERT INTO roles (id, name) VALUES (91, 'ROLE_STUDENT');

INSERT INTO members_roles (member_id, role_id) VALUES (91, 91);
INSERT INTO members_roles (member_id, role_id) VALUES (92, 91);

INSERT INTO events(id, name, start_date_time, end_date_time, account_type) VALUES(91, 'some-event', '2024-01-15 00:00:00', '2024-02-15 00:00:00', 'DINING_POINTS');

INSERT INTO events_members(event_id, member_id) VALUES(91, 91);
INSERT INTO events_members(event_id, member_id) VALUES(91, 92);

INSERT INTO sessions(id, name, event_id) VALUES(91, 'some-session', 91);
INSERT INTO sessions(id, name, event_id) VALUES(92, 'other-session', 91);

INSERT INTO records(id, member_id, session_id) VALUES(91, 91, 91);
INSERT INTO records(id, member_id, session_id) VALUES(92, 91, 92);
INSERT INTO records(id, member_id, session_id) VALUES(93, 92, 91);