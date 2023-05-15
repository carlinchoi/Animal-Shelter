#!/bin/bash
export PGHOST=rockville.camiy8mamiwh.us-west-1.rds.amazonaws.com
export PGPASSWORD='gogosing'

BASEDIR=$(dirname $0)
DATABASE=final_capstone
psql -U postgres -f "$BASEDIR/dropdb.sql" &&
createdb -U postgres $DATABASE &&
psql -U postgres -d $DATABASE -f "$BASEDIR/schema.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/data.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/user.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/fakeAnimals.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/InsertAdminVolDummy.sql"

