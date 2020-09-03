CREATE TABLE furniture
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(255),
    colour     VARCHAR(255),
    country    VARCHAR(255),
    material   VARCHAR(255),
    created_at TIMESTAMP DEFAULT current_timestamp,
    updated_at TIMESTAMP DEFAULT current_timestamp
);

INSERT INTO furniture
    (name, colour, country, material)
    VALUES
        ('Table 1', 'black', 'Russia', 'oak'),
        ('Table 2', 'yellow', 'Russia', 'pine'),
        ('Table 3', 'white', 'China', 'plastic'),
        ('Chair 1', 'black', 'Russia', 'oak'),
        ('Wardrobe', 'dark blue', 'Sweden', 'oak');
