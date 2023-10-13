-- Retail
INSERT INTO project(id, created_at, name, description, "order", parent_project_id, root_project_id)
values (1, '2023-09-09T11:25:32.0345', 'Retail', 'Retail Project', 2323, null, null);

INSERT INTO project(id, created_at, name, description, "order", parent_project_id, root_project_id)
values (2, '2023-09-09T11:25:32.0345', 'Customer Satisfaction', 'Customer Satisfaction Sub Project', 423, 1, 1);

INSERT INTO project(id, created_at, name, description, "order", parent_project_id, root_project_id)
values (3, '2023-09-09T11:25:32.0345', 'Stock', 'Stock Sub Project', 2311, 1, 1);

INSERT INTO project(id, created_at, name, description, "order", parent_project_id, root_project_id)
values (4, '2023-09-09T11:25:32.0345', 'Stock per Region', 'Stock per Region Sub Project', 132, 3, 1);

INSERT INTO project(id, created_at, name, description, "order", parent_project_id, root_project_id)
values (5, '2023-09-09T11:25:32.0345', 'Sales', 'Sales Project', 32321, 1, 1);

-- Marketing

INSERT INTO project(id, created_at, name, description, "order", parent_project_id, root_project_id)
values (6, '2023-09-09T11:25:32.0345', 'Marketing', 'Marketing Project', 41123, null, null);

INSERT INTO project(id, created_at, name, description, "order", parent_project_id, root_project_id)
values (7, '2023-09-09T11:25:32.0345', 'Promotions', 'Promotions Sub Project', 2311, 6, 6);

INSERT INTO project(id, created_at, name, description, "order", parent_project_id, root_project_id)
values (8, '2023-09-09T11:25:32.0345', 'Campaigns', 'Campaigns Project', 132, 7, 6);

INSERT INTO project(id, created_at, name, description, "order", parent_project_id, root_project_id)
values (9, '2023-09-09T11:25:32.0345', 'Themes', 'Themes Project', 32321, 8, 6);

