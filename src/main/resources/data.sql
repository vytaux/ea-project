 INSERT INTO members (id, firstname) VALUES (1, 'somename');
 INSERT INTO members (id, firstname) VALUES (2, 'adonay');

INSERT INTO events (id)    VALUES (1);

INSERT INTO events_members(member_id,event_id)  VALUES (1,1);
 INSERT INTO events_members(member_id,event_id)  VALUES (2,1);

INSERT INTO sessions (id, event_id) VALUES (1,1);
 INSERT INTO sessions (id, event_id) VALUES (2,1);

INSERT INTO records (session_id,member_id)  VALUES (1,1);
 INSERT INTO records (session_id,member_id)  VALUES (1,2);
 INSERT INTO records (session_id,member_id)  VALUES (2,2);

