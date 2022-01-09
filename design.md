# Libraries

- #### [pynetworktables](https://robotpy.readthedocs.io/en/stable/install/pynetworktables.html#install-pynetworktables)

---

# Robot Goals

- Collect cargo from the floor
- Automatically aim the shooter towards the goal
- Traverse the bar's
- Shoot from most places on the field

---

# Subsystems

## Base 🚧

- #### Capabilities

  - Controlling the swerve pods
  - Following paths from pathweaver

- #### Devices
  - (x8) Falcon 500s
  - (x4) Cancoders

## Shooter 🚧

- #### Devices

  - (x2) Falcon 500s?
  - [Limelight 2+](https://docs.limelightvision.io/en/latest/getting_started.html)

- #### Capabilities

  - Automatically change the heading of the shooter to match goal
  - Getting the distance from the goal to know how much power is needed. [link](https://docs.limelightvision.io/en/latest/cs_estimating_distance.html)

## Intake 🚧

## Climber 🚧

- ### Capabilities

  - Being able to know current

- ### Devices
  - REV Neos'?

## Networking 🚧

- #### Capabilities
  - Communicating with external devices on robot rasperry pi's, jetson's, limelights, etc
  - Creating UDP connections
  - Connection health checks's

## Robot State 🚧

Instead of having health checks in one central subsystem each subsystem can handle health checks for its components

- ### Subsystem health checks

  _Note:_ if health check fails it should be reported to the dashboard via Shuffleboard

  - #### Compute Devices (pi's, jetson's, odroid's, etc)

    - Send a routine ping to check server status

  - #### Shooter
    - Check if the limelight is responding to network table requests

- ### Auto states

  - store current path
  - list of available paths

  - #### handling dashboard input to run the desired auto
    - Check shuffleboard for selected mode on auto init

---

# Limelight

The limelight will need to be running in _Dual Crosshair Mode_ to allow it to adjust to moving goal
