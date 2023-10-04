CREATE OR REPLACE FUNCTION set_mission_assignment_end_date() 
RETURNS TRIGGER AS $$
BEGIN 

    UPDATE missionassignments
    SET assignmentenddate = NEW.assignmentstartdate - INTERVAL '1 day'
    WHERE employeeId = NEW.employeeId
    AND assignmentenddate IS NULL;

    RETURN NEW;
END;
$$
LANGUAGE plpgsql;