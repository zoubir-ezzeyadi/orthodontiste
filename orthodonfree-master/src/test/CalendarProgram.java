/*     */ package test;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.util.GregorianCalendar;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.UnsupportedLookAndFeelException;
/*     */ import javax.swing.table.DefaultTableCellRenderer;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ import javax.swing.table.JTableHeader;
/*     */ 
/*     */ public class CalendarProgram
/*     */ {
/*     */   static JLabel lblMonth;
/*     */   static JLabel lblYear;
/*     */   static JButton btnPrev;
/*     */   static JButton btnNext;
/*     */   static JTable tblCalendar;
/*     */   static JComboBox cmbYear;
/*     */   static JFrame frmMain;
/*     */   static Container pane;
/*     */   static DefaultTableModel mtblCalendar;
/*     */   static JScrollPane stblCalendar;
/*     */   static JPanel pnlCalendar;
/*     */   static int realYear;
/*     */   static int realMonth;
/*     */   static int realDay;
/*     */   static int currentYear;
/*     */   static int currentMonth;
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
/*     */     } catch (ClassNotFoundException localClassNotFoundException) {
/*     */     } catch (InstantiationException localInstantiationException) {
/*     */     } catch (IllegalAccessException localIllegalAccessException) {
/*     */     }
/*     */     catch (UnsupportedLookAndFeelException localUnsupportedLookAndFeelException) {
/*     */     }
/*  34 */     frmMain = new JFrame("Gestionnaire de clients");
/*  35 */     frmMain.setSize(330, 375);
/*  36 */     pane = frmMain.getContentPane();
/*  37 */     pane.setLayout(null);
/*  38 */     frmMain.setDefaultCloseOperation(3);
/*     */ 
/*  41 */     lblMonth = new JLabel("January");
/*  42 */     lblYear = new JLabel("Change year:");
/*  43 */     cmbYear = new JComboBox();
/*  44 */     btnPrev = new JButton("<<");
/*  45 */     btnNext = new JButton(">>");
/*  46 */     mtblCalendar = new DefaultTableModel() { public boolean isCellEditable(int rowIndex, int mColIndex) { return false;
/*     */       }
/*     */     };
/*  47 */     tblCalendar = new JTable(mtblCalendar);
/*  48 */     stblCalendar = new JScrollPane(tblCalendar);
/*  49 */     pnlCalendar = new JPanel(null);
/*     */ 
/*  52 */     pnlCalendar.setBorder(BorderFactory.createTitledBorder("Calendar"));
/*     */ 
/*  55 */     btnPrev.addActionListener(new btnPrev_Action());
/*  56 */     btnNext.addActionListener(new btnNext_Action());
/*  57 */     cmbYear.addActionListener(new cmbYear_Action());
/*     */ 
/*  60 */     pane.add(pnlCalendar);
/*  61 */     pnlCalendar.add(lblMonth);
/*  62 */     pnlCalendar.add(lblYear);
/*  63 */     pnlCalendar.add(cmbYear);
/*  64 */     pnlCalendar.add(btnPrev);
/*  65 */     pnlCalendar.add(btnNext);
/*  66 */     pnlCalendar.add(stblCalendar);
/*     */ 
/*  69 */     pnlCalendar.setBounds(0, 0, 320, 335);
/*  70 */     lblMonth.setBounds(160 - lblMonth.getPreferredSize().width / 2, 25, 100, 25);
/*  71 */     lblYear.setBounds(10, 305, 80, 20);
/*  72 */     cmbYear.setBounds(230, 305, 80, 20);
/*  73 */     btnPrev.setBounds(10, 25, 50, 25);
/*  74 */     btnNext.setBounds(260, 25, 50, 25);
/*  75 */     stblCalendar.setBounds(10, 50, 300, 250);
/*     */ 
/*  78 */     frmMain.setResizable(false);
/*  79 */     frmMain.setVisible(true);
/*     */ 
/*  82 */     GregorianCalendar cal = new GregorianCalendar();
/*  83 */     realDay = cal.get(5);
/*  84 */     realMonth = cal.get(2);
/*  85 */     realYear = cal.get(1);
/*  86 */     currentMonth = realMonth;
/*  87 */     currentYear = realYear;
/*     */ 
/*  90 */     String[] headers = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
/*  91 */     for (int i = 0; i < 7; i++) {
/*  92 */       mtblCalendar.addColumn(headers[i]);
/*     */     }
/*     */ 
/*  95 */     tblCalendar.getParent().setBackground(tblCalendar.getBackground());
/*     */ 
/*  98 */     tblCalendar.getTableHeader().setResizingAllowed(false);
/*  99 */     tblCalendar.getTableHeader().setReorderingAllowed(false);
/*     */ 
/* 102 */     tblCalendar.setColumnSelectionAllowed(true);
/* 103 */     tblCalendar.setRowSelectionAllowed(true);
/* 104 */     tblCalendar.setSelectionMode(0);
/*     */ 
/* 107 */     tblCalendar.setRowHeight(38);
/* 108 */     mtblCalendar.setColumnCount(7);
/* 109 */     mtblCalendar.setRowCount(6);
/*     */ 
/* 112 */     for (int i = realYear - 100; i <= realYear + 100; i++) {
/* 113 */       cmbYear.addItem(String.valueOf(i));
/*     */     }
/*     */ 
/* 117 */     refreshCalendar(realMonth, realYear);
/*     */   }
/*     */ 
/*     */   public static void refreshCalendar(int month, int year)
/*     */   {
/* 122 */     String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
/*     */ 
/* 126 */     btnPrev.setEnabled(true);
/* 127 */     btnNext.setEnabled(true);
/* 128 */     if ((month == 0) && (year <= realYear - 10)) btnPrev.setEnabled(false);
/* 129 */     if ((month == 11) && (year >= realYear + 100)) btnNext.setEnabled(false);
/* 130 */     lblMonth.setText(months[month]);
/* 131 */     lblMonth.setBounds(160 - lblMonth.getPreferredSize().width / 2, 25, 180, 25);
/* 132 */     cmbYear.setSelectedItem(String.valueOf(year));
/*     */ 
/* 135 */     for (int i = 0; i < 6; i++) {
/* 136 */       for (int j = 0; j < 7; j++) {
/* 137 */         mtblCalendar.setValueAt(null, i, j);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 142 */     GregorianCalendar cal = new GregorianCalendar(year, month, 1);
/* 143 */     int nod = cal.getActualMaximum(5);
/* 144 */     int som = cal.get(7);
/*     */ 
/* 147 */     for (int i = 1; i <= nod; i++) {
/* 148 */       int row = new Integer((i + som - 2) / 7).intValue();
/* 149 */       int column = (i + som - 2) % 7;
/* 150 */       mtblCalendar.setValueAt(Integer.valueOf(i), row, column);
/*     */     }
/*     */ 
/* 154 */     tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());
/*     */   }
/*     */ 
/*     */   static class btnNext_Action
/*     */     implements ActionListener
/*     */   {
/*     */     public void actionPerformed(ActionEvent e)
/*     */     {
/* 191 */       if (CalendarProgram.currentMonth == 11) {
/* 192 */         CalendarProgram.currentMonth = 0;
/* 193 */         CalendarProgram.currentYear += 1;
/*     */       }
/*     */       else {
/* 196 */         CalendarProgram.currentMonth += 1;
/*     */       }
/* 198 */       CalendarProgram.refreshCalendar(CalendarProgram.currentMonth, CalendarProgram.currentYear);
/*     */     }
/*     */   }
/*     */ 
/*     */   static class btnPrev_Action
/*     */     implements ActionListener
/*     */   {
/*     */     public void actionPerformed(ActionEvent e)
/*     */     {
/* 179 */       if (CalendarProgram.currentMonth == 0) {
/* 180 */         CalendarProgram.currentMonth = 11;
/* 181 */         CalendarProgram.currentYear -= 1;
/*     */       }
/*     */       else {
/* 184 */         CalendarProgram.currentMonth -= 1;
/*     */       }
/* 186 */       CalendarProgram.refreshCalendar(CalendarProgram.currentMonth, CalendarProgram.currentYear);
/*     */     }
/*     */   }
/*     */ 
/*     */   static class cmbYear_Action
/*     */     implements ActionListener
/*     */   {
/*     */     public void actionPerformed(ActionEvent e)
/*     */     {
/* 203 */       if (CalendarProgram.cmbYear.getSelectedItem() != null) {
/* 204 */         String b = CalendarProgram.cmbYear.getSelectedItem().toString();
/* 205 */         CalendarProgram.currentYear = Integer.parseInt(b);
/* 206 */         CalendarProgram.refreshCalendar(CalendarProgram.currentMonth, CalendarProgram.currentYear);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   static class tblCalendarRenderer extends DefaultTableCellRenderer
/*     */   {
/*     */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column)
/*     */     {
/* 159 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 160 */       if ((column == 0) || (column == 6)) {
/* 161 */         setBackground(new Color(255, 220, 220));
/*     */       }
/*     */       else {
/* 164 */         setBackground(new Color(255, 255, 255));
/*     */       }
/* 166 */       if ((value != null) && 
/* 167 */         (Integer.parseInt(value.toString()) == CalendarProgram.realDay) && (CalendarProgram.currentMonth == CalendarProgram.realMonth) && (CalendarProgram.currentYear == CalendarProgram.realYear)) {
/* 168 */         setBackground(new Color(220, 220, 255));
/*     */       }
/*     */ 
/* 171 */       setBorder(null);
/* 172 */       setForeground(Color.black);
/* 173 */       return this;
/*     */     }
/*     */   }
/*     */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     test.CalendarProgram
 * JD-Core Version:    0.6.0
 */