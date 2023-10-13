INSERT INTO public.user(id, name, username, email, password, created_at)
VALUES (1, 'john', 'admin', 'admin@gmail.com', '$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu', null),
       (2, 'tom', 'test', 'test@gmail.com', '$2a$12$TYSPPDsgR1T9vpgMSavOteZoqzjGVLt7rzsqKLrGL4oQdE3rWDNru', null),
       (3, 'sam', 'test2', 'test2@gmail.com', '$2c$12$TYSPPDsgR1T9vpgMSavOteZoqzjGVLt7rzsqKLrGL4oQdE3rWDNru', null);

INSERT INTO public.role
VALUES (1, 'ADMIN'),
       (2, 'ANALYST'),
       (3, 'BASIC');

INSERT INTO public.user_roles
VALUES (1, 1),
       (2, 2),
       (3, 3);