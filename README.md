# MAD Practical – 4 : Android Alarm Application (Service & BroadcastReceiver)

This Android application demonstrates how to create an **Alarm App** using `Service`, `BroadcastReceiver`, `AlarmManager`, and `PendingIntent`.  
It includes a UI for selecting time, scheduling alarms, and triggering alarm audio using `MediaPlayer`.  
This practical focuses on core Android components and background task handling.

---

## 📌 AIM  
Create an Android Alarm application by using **Service** & **BroadcastReceiver**.

---

## 📝 Tasks Completed

1. **Create `MainActivity`** according to the provided UI design.  
2. **Create `AlarmBroadcastReceiver` class** to receive alarm triggers.  
3. **Create `AlarmService` class** to play alarm sound and handle alarm actions.  
4. **Add `android.permission.SCHEDULE_EXACT_ALARM`** permission in the AndroidManifest.

---

## 📚 Study / Concepts Used

This practical covers the following Android topics:

- **BroadcastReceiver**
- **Service**
- **TextClock**
- **TimePickerDialog**
- **Calendar Class**
- **SimpleDateFormat Class**
- **PendingIntent**
- **AlarmManager**
- **getSystemService() method**
- **sendBroadcast() method**
- **MediaPlayer**
- **startService() / stopService()**
- **Intent.putStringExtra() / Intent.getStringExtra()**
- **MaterialCardView**

---

## ✨ Features

- Choose alarm time using `TimePickerDialog`.
- Set exact alarm using `AlarmManager` and `PendingIntent`.
- Alarm automatically triggers using `BroadcastReceiver`.
- Plays sound using `MediaPlayer` via a background `Service`.
- Stop alarm functionality included.
- Clean, modern UI using `MaterialCardView`.
- Uses `TextClock` to display current time.

---

## 🚀 How the App Works

1. **Launch the App**  
   The main screen shows the current time (`TextClock`) and allows the user to pick the alarm time.

2. **Set Alarm**  
   - Tap the “Set Alarm” button.
   - Select the desired time using the `TimePickerDialog`.
   - The system schedules the alarm using `AlarmManager` with an exact trigger (`SCHEDULE_EXACT_ALARM`).

3. **Alarm Trigger**  
   - When the selected time is reached, the `AlarmBroadcastReceiver` receives the broadcast.
   - It then starts the `AlarmService` to play alarm audio via `MediaPlayer`.

4. **Stop Alarm**  
   - The user can stop the alarm sound (e.g., via a button or action handled by `AlarmService`).

---

## 🏗️ Project Structure



<table>
  <tr>
    <th>Main UI:</th>
    <th colspan="3">OnCreate Alarm:</th>
    <th>OnCancel Button:</th>
  </tr>
  <tr>
    <td><img width="366" height="804" alt="image" src="https://github.com/user-attachments/assets/c67ff967-3c39-441d-bf9c-a3ac53d72abc" /></td>
      <td><img width="365" height="802" alt="image" src="https://github.com/user-attachments/assets/d7fd63f6-dd47-463d-9917-ea4c073bf662" /></td>
      <td><img width="365" height="802" alt="image" src="https://github.com/user-attachments/assets/e5cfff1c-120a-44ec-9491-803f7d861f36" /></td>
      <td><img width="365" height="802" alt="image" src="https://github.com/user-attachments/assets/3ca6727a-7cb2-4d48-b88f-b8e950e34109" /></td>
    <td><img width="362" height="809" alt="image" src="https://github.com/user-attachments/assets/4139cb15-05ad-4817-a18e-d477bcd6d213" /></td>
  </tr>
</table>




   





