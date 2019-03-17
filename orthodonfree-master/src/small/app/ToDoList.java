/*     */ package small.app;
/*     */ 
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.util.Date;
/*     */ import java.util.GregorianCalendar;
/*     */ import javax.swing.DefaultListModel;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JRadioButton;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTabbedPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.table.AbstractTableModel;
/*     */ import javax.swing.table.TableColumn;
/*     */ import javax.swing.table.TableModel;
/*     */ 
/*     */ public class ToDoList extends JFrame
/*     */ {
/*  16 */   private JButton ivjJButton1 = null;
/*  17 */   private JPanel ivjJFrameContentPane = null;
/*  18 */   private JLabel ivjJLabel1 = null;
/*  19 */   private JLabel ivjJLabel11 = null;
/*  20 */   private JTextField ivjJTextField1 = null;
/*  21 */   private JScrollPane ivjJScrollPane = null;
/*  22 */   private JTable ivjJTable = null;
/*  23 */   private TableColumn ivjTableColumn = null;
/*  24 */   private TableColumn ivjTableColumn2 = null;
/*  25 */   private int taskCount = 0;
/*  26 */   private JTabbedPane ivjJTabbedPane = null;
/*  27 */   private JScrollPane ivjJScrollPane2 = null;
/*  28 */   private JList ivjJList = null;
/*  29 */   private JRadioButton jRadioButton = null;
/*  30 */   private JRadioButton jRadioButton1 = null;
/*     */ 
/*     */   public ToDoList() {
/*  33 */     initialize();
/*     */   }
/*     */ 
/*     */   private JButton getJButton1()
/*     */   {
/*  41 */     if (this.ivjJButton1 == null) {
/*  42 */       this.ivjJButton1 = new JButton();
/*  43 */       this.ivjJButton1.setName("JButton1");
/*  44 */       this.ivjJButton1.setText("Add Item");
/*  45 */       this.ivjJButton1.setBounds(188, 15, 131, 25);
/*  46 */       this.ivjJButton1.addActionListener(new ActionListener() {
/*     */         public void actionPerformed(ActionEvent arg0) {
/*  48 */           String newTask = ToDoList.this.getJTextField1().getText();
/*  49 */           if (!newTask.equals("")) {
/*  50 */             DefaultListModel listModel = (DefaultListModel)ToDoList.this.getIvjJList()
/*  51 */               .getModel();
/*  52 */             listModel.addElement(newTask);
/*  53 */             TableModel model = ToDoList.this.getIvjJTable().getModel();
/*  54 */             model.setValueAt(newTask, ToDoList.this.taskCount, 0);
/*  55 */             model.setValueAt(new GregorianCalendar().getTime()
/*  56 */               .toString(), ToDoList.this.taskCount, 1);
/*  57 */             ToDoList.this.getJTextField1().setText("");
/*  58 */             if (ToDoList.this.taskCount < model.getRowCount() - 1)
/*  59 */               ToDoList.this.taskCount += 1;
/*     */           }
/*     */         } } );
/*     */     }
/*  64 */     return this.ivjJButton1;
/*     */   }
/*     */ 
/*     */   private JPanel getJFrameContentPane()
/*     */   {
/*  72 */     if (this.ivjJFrameContentPane == null) {
/*  73 */       this.ivjJFrameContentPane = new JPanel();
/*  74 */       this.ivjJFrameContentPane.setName("JFrameContentPane");
/*  75 */       this.ivjJFrameContentPane.setLayout(null);
/*  76 */       getJFrameContentPane().add(getJLabel1(), getJLabel1().getName());
/*  77 */       getJFrameContentPane().add(getJTextField1(), 
/*  78 */         getJTextField1().getName());
/*  79 */       getJFrameContentPane().add(getJButton1(), getJButton1().getName());
/*  80 */       getJFrameContentPane().add(getJLabel11(), getJLabel11().getName());
/*  81 */       this.ivjJFrameContentPane.add(getIvjJTabbedPane(), getIvjJTabbedPane()
/*  82 */         .getName());
/*  83 */       this.ivjJFrameContentPane.add(getJRadioButton(), null);
/*  84 */       this.ivjJFrameContentPane.add(getJRadioButton1(), null);
/*     */     }
/*  86 */     return this.ivjJFrameContentPane;
/*     */   }
/*     */ 
/*     */   private JLabel getJLabel1()
/*     */   {
/*  94 */     if (this.ivjJLabel1 == null) {
/*  95 */       this.ivjJLabel1 = new JLabel();
/*  96 */       this.ivjJLabel1.setName("JLabel1");
/*  97 */       this.ivjJLabel1.setText("To-Do Item");
/*  98 */       this.ivjJLabel1.setBounds(10, 33, 98, 15);
/*     */     }
/* 100 */     return this.ivjJLabel1;
/*     */   }
/*     */ 
/*     */   private JLabel getJLabel11()
/*     */   {
/* 108 */     if (this.ivjJLabel11 == null) {
/* 109 */       this.ivjJLabel11 = new JLabel();
/* 110 */       this.ivjJLabel11.setName("JLabel11");
/* 111 */       this.ivjJLabel11.setText("To-Do List");
/* 112 */       this.ivjJLabel11.setBounds(10, 89, 98, 15);
/*     */     }
/* 114 */     return this.ivjJLabel11;
/*     */   }
/*     */ 
/*     */   private JTextField getJTextField1()
/*     */   {
/* 122 */     if (this.ivjJTextField1 == null) {
/* 123 */       this.ivjJTextField1 = new JTextField();
/* 124 */       this.ivjJTextField1.setName("JTextField1");
/* 125 */       this.ivjJTextField1.setBounds(10, 57, 140, 19);
/* 126 */       this.ivjJTextField1.addActionListener(new ActionListener() {
/*     */         public void actionPerformed(ActionEvent arg0) {
/* 128 */           String newTask = ToDoList.this.getJTextField1().getText();
/* 129 */           if (!newTask.equals("")) {
/* 130 */             DefaultListModel listModel = (DefaultListModel)ToDoList.this.getIvjJList()
/* 131 */               .getModel();
/* 132 */             listModel.addElement(newTask);
/* 133 */             TableModel model = ToDoList.this.getIvjJTable().getModel();
/* 134 */             model.setValueAt(newTask, ToDoList.this.taskCount, 0);
/* 135 */             model.setValueAt(new GregorianCalendar().getTime()
/* 136 */               .toString(), ToDoList.this.taskCount, 1);
/* 137 */             ToDoList.this.getJTextField1().setText("");
/* 138 */             if (ToDoList.this.taskCount < model.getRowCount() - 1)
/* 139 */               ToDoList.this.taskCount += 1;
/*     */           }
/*     */         } } );
/*     */     }
/* 144 */     return this.ivjJTextField1;
/*     */   }
/*     */ 
/*     */   private void initialize()
/*     */   {
/* 151 */     setName("JFrame1");
/* 152 */     setDefaultCloseOperation(2);
/* 153 */     setSize(354, 315);
/* 154 */     setTitle("To-Do List  Swing Controls");
/* 155 */     setContentPane(getJFrameContentPane());
/*     */   }
/*     */ 
/*     */   private JScrollPane getIvjJScrollPane()
/*     */   {
/* 165 */     if (this.ivjJScrollPane == null) {
/* 166 */       this.ivjJScrollPane = new JScrollPane();
/* 167 */       this.ivjJScrollPane.setViewportView(getIvjJTable());
/* 168 */       this.ivjJScrollPane.setBounds(10, 130, 329, 146);
/*     */     }
/* 170 */     return this.ivjJScrollPane;
/*     */   }
/*     */ 
/*     */   private JTable getIvjJTable()
/*     */   {
/* 214 */     if (this.ivjJTable == null) {
/* 215 */       this.ivjJTable = new JTable();
/* 216 */       this.ivjJTable.addColumn(getIvjTableColumn());
/* 217 */       this.ivjJTable.addColumn(getIvjTableColumn2());
/* 218 */       this.ivjJTable.setAutoCreateColumnsFromModel(false);
/* 219 */       this.ivjJTable.setModel(new ToDoListModel());
/*     */     }
/* 221 */     return this.ivjJTable;
/*     */   }
/*     */ 
/*     */   private TableColumn getIvjTableColumn()
/*     */   {
/* 230 */     if (this.ivjTableColumn == null) {
/* 231 */       this.ivjTableColumn = new TableColumn();
/* 232 */       this.ivjTableColumn.setHeaderValue("Task");
/* 233 */       this.ivjTableColumn.setPreferredWidth(40);
/* 234 */       this.ivjTableColumn.setResizable(false);
/* 235 */       this.ivjTableColumn.setModelIndex(0);
/*     */     }
/* 237 */     return this.ivjTableColumn;
/*     */   }
/*     */ 
/*     */   private TableColumn getIvjTableColumn2()
/*     */   {
/* 246 */     if (this.ivjTableColumn2 == null) {
/* 247 */       this.ivjTableColumn2 = new TableColumn();
/* 248 */       this.ivjTableColumn2.setHeaderValue("Time Added");
/* 249 */       this.ivjTableColumn2.setPreferredWidth(90);
/* 250 */       this.ivjTableColumn2.setModelIndex(1);
/*     */     }
/* 252 */     return this.ivjTableColumn2;
/*     */   }
/*     */ 
/*     */   private JTabbedPane getIvjJTabbedPane()
/*     */   {
/* 261 */     if (this.ivjJTabbedPane == null) {
/* 262 */       this.ivjJTabbedPane = new JTabbedPane();
/* 263 */       this.ivjJTabbedPane
/* 264 */         .addTab("Task List", null, getIvjJScrollPane2(), null);
/* 265 */       this.ivjJTabbedPane.addTab("Details", null, getIvjJScrollPane(), null);
/* 266 */       this.ivjJTabbedPane.setBounds(5, 120, 335, 165);
/*     */     }
/* 268 */     return this.ivjJTabbedPane;
/*     */   }
/*     */ 
/*     */   private JScrollPane getIvjJScrollPane2()
/*     */   {
/* 277 */     if (this.ivjJScrollPane2 == null) {
/* 278 */       this.ivjJScrollPane2 = new JScrollPane();
/* 279 */       this.ivjJScrollPane2.setViewportView(getIvjJList());
/*     */     }
/* 281 */     return this.ivjJScrollPane2;
/*     */   }
/*     */ 
/*     */   private JList getIvjJList()
/*     */   {
/* 290 */     if (this.ivjJList == null) {
/* 291 */       this.ivjJList = new JList();
/* 292 */       this.ivjJList.setModel(new DefaultListModel());
/*     */     }
/* 294 */     return this.ivjJList;
/*     */   }
/*     */ 
/*     */   private JRadioButton getJRadioButton()
/*     */   {
/* 303 */     if (this.jRadioButton == null) {
/* 304 */       this.jRadioButton = new JRadioButton("Actif");
/* 305 */       this.jRadioButton.setBounds(new Rectangle(222, 62, 92, 21));
/*     */     }
/* 307 */     return this.jRadioButton;
/*     */   }
/*     */ 
/*     */   private JRadioButton getJRadioButton1()
/*     */   {
/* 316 */     if (this.jRadioButton1 == null) {
/* 317 */       this.jRadioButton1 = new JRadioButton();
/* 318 */       this.jRadioButton1.setBounds(new Rectangle(225, 93, 21, 21));
/*     */     }
/* 320 */     return this.jRadioButton1;
/*     */   }
/*     */ 
/*     */   public static class ToDoListModel extends AbstractTableModel
/*     */   {
/* 178 */     String[][] data = { { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" } };
/*     */ 
/*     */     public Object getValueAt(int rowIndex, int columnIndex)
/*     */     {
/* 187 */       return this.data[rowIndex][columnIndex];
/*     */     }
/*     */ 
/*     */     public int getColumnCount() {
/* 191 */       return 0;
/*     */     }
/*     */ 
/*     */     public int getRowCount() {
/* 195 */       return this.data.length;
/*     */     }
/*     */ 
/*     */     public String getColumnName(int c) {
/* 199 */       return "";
/*     */     }
/*     */ 
/*     */     public void setValueAt(Object arg0, int arg1, int arg2) {
/* 203 */       this.data[arg1][arg2] = ((String)arg0);
/* 204 */       fireTableDataChanged();
/*     */     }
/*     */   }
/*     */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     small.app.ToDoList
 * JD-Core Version:    0.6.0
 */